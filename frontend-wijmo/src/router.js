
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import Manager from "./components/ui/Grid"
import ProjectMasterManager from "./components/ui/ProjectMasterGrid"




import Manager from "./components/ui/Grid"
import BudgetManager from "./components/ui/BudgetGrid"

import Manager from "./components/ui/Grid"
import ResearcherManager from "./components/ui/ResearcherGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/',
                name: 'Manager',
                component: Manager
            },
            {
                path: '/projectMasters',
                name: 'ProjectMasterManager',
                component: ProjectMasterManager
            },




            {
                path: '/',
                name: 'Manager',
                component: Manager
            },
            {
                path: '/budgets',
                name: 'BudgetManager',
                component: BudgetManager
            },

            {
                path: '/',
                name: 'Manager',
                component: Manager
            },
            {
                path: '/researchers',
                name: 'ResearcherManager',
                component: ResearcherManager
            },



    ]
})
