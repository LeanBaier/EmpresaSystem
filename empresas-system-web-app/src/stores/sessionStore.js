import {defineStore} from 'pinia'

const user_cookie = 'USER_COOKIE'

export const userSession = defineStore('userSession', {
    state: () => ({
        accessToken: '',
        refreshToken: '',
        expirationAccessToken: 0,
    }),
    getters: {
        getAccessToken: (state) => state.accessToken,
        async sessionToken() {
            if (!this.refreshToken) {
                this.refreshToken = JSON.parse(localStorage.getItem(user_cookie)).refreshToken
            }
            if (this.expirationAccessToken && this.expirationAccessToken <= new Date().getTime() / 1000) {

                let data = {
                    refreshToken: this.refreshToken,
                }
                let headers = new Headers();
                headers.append('Content-Type', 'application/json')
                await fetch("/api-employees/api/v1/auth/token", {
                    method: 'POST',
                    mode: 'cors',
                    headers: headers,
                    body: JSON.stringify(data)
                }).then(async (result) => {
                    result = await result.json()
                    this.accessToken = result.accessToken
                    this.refreshToken = result.refreshToken
                    this.expirationAccessToken = new Date().getTime() / 1000 + result.expiresIn
                }).catch((e) => console.log(e))
            }
            return this.getAccessToken
        }
    },
    actions: {
        async login(username, password) {
            let data = {
                username: username,
                password: password
            }
            let headers = new Headers();
            headers.append('Content-Type', 'application/json')
            await fetch("/api-employees/api/v1/auth/login", {
                method: 'POST',
                mode: 'cors',
                headers: headers,
                body: JSON.stringify(data)
            }).then(async (result) => {
                result = await result.json()
                console.log(result)
                this.accessToken = result.accessToken
                this.refreshToken = result.refreshToken
                this.expirationAccessToken = result.expires
                localStorage.setItem(user_cookie, JSON.stringify({refreshToken: this.refreshToken}))
            }).catch((e) => console.log(e))
        },
        logout() {
            this.accessToken = ''
            this.refreshToken = ''
            this.expirationAccessToken = 0
            localStorage.removeItem(user_cookie)
        }
    }
})