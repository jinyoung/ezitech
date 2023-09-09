
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProjectMasterManager from "./components/ui/ProjectMasterGrid"




import BudgetManager from "./components/ui/BudgetGrid"

import ResearcherManager from "./components/ui/ResearcherGrid"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/projectMasters',
                name: 'ProjectMasterManager',
                component: ProjectMasterManager
            },



            {
                path: '/budgets',
                name: 'BudgetManager',
                component: BudgetManager
            },

            {
                path: '/researchers',
                name: 'ResearcherManager',
                component: ResearcherManager
            },



    ]
})
