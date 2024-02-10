import {createRouter, createWebHistory} from 'vue-router'
import HomeView from '../views/HomeView.vue'
import {userSession} from "@/stores/sessionStore.js";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/home',
            name: 'home',
            component: HomeView
        },
        {
            path: '/employees',
            name: 'employees',
            component: () => import('../views/EmployeesView.vue')
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('../views/LoginView.vue')
        },
        {
            path: '/register',
            name: 'register',
            component: () => import('../views/RegisterView.vue')
        },
        {
            path: '/employees/new',
            name: 'newEmployee',
            component: () => import('../views/NewEmployeeView.vue')
        }
    ]
})

router.beforeEach(async (to) => {
    const publicPages = ['/login', '/register']
    const authRequired = !publicPages.includes(to.path)
    const auth = userSession().getAccessToken
    if (authRequired && !auth) {
        return '/login'
    }

})

export default router
