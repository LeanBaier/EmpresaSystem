import {defineStore} from 'pinia'

export const userSession = defineStore('userSession', {
    state: () => ({
        accessToken: '',
        refreshToken: '',
        expirationAccessToken: 0,
    }),
    getters: {
        getAccessToken: (state) => state.accessToken ,
        async sessionToken(refreshSession) {
            if (refreshSession) {
                let data = {
                    refreshToken: this.refreshToken,
                }
                let headers = new Headers();
                headers.append('Content-Type', 'application/json')
                await fetch("http://localhost:8080/api/v1/auth/token", {
                    method: 'POST',
                    mode: 'cors',
                    headers: headers,
                    body: JSON.stringify(data)
                }).then(async (result) => {
                    result = await result.json()
                    this.accessToken = result.accessToken
                    this.refreshToken = result.refreshToken
                    this.expirationAccessToken = result.expires
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
            await fetch("http://localhost:8080/api/v1/auth/login", {
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
            }).catch((e) => console.log(e))
        },
        logout() {
            this.accessToken = ''
            this.refreshToken = ''
            this.expirationAccessToken = 0
        }
    }
})