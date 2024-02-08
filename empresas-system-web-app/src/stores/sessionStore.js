import {defineStore} from 'pinia'

export const userSession = defineStore('userSession', {
    state: () => ({
        accessToken: '',
        refreshToken: '',
        expirationAccessToken: 0,
    }),
    getters: {
        async sessionToken(refreshSession) {
            if (refreshSession) {
                let data = {
                    refreshToken: state.refreshToken,
                }
                let headers = new Headers();
                headers.append('Content-Type', 'application/json')
                let result = await fetch("http://localhost:8080/api/v1/auth/token", {
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
            return state.accessToken
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
            let result = await fetch("http://localhost:8080/api/v1/auth/login", {
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
    }
})