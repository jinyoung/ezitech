
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import RegistrationProjectMasterManager from "./components/listers/RegistrationProjectMasterCards"
import RegistrationProjectMasterDetail from "./components/listers/RegistrationProjectMasterDetail"




import BudgetBudgetManager from "./components/listers/BudgetBudgetCards"
import BudgetBudgetDetail from "./components/listers/BudgetBudgetDetail"

import ParticipationRateResearcherManager from "./components/listers/ParticipationRateResearcherCards"
import ParticipationRateResearcherDetail from "./components/listers/ParticipationRateResearcherDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/registrations/projectMasters',
                name: 'RegistrationProjectMasterManager',
                component: RegistrationProjectMasterManager
            },
            {
                path: '/registrations/projectMasters/:id',
                name: 'RegistrationProjectMasterDetail',
                component: RegistrationProjectMasterDetail
            },




            {
                path: '/budgets/budgets',
                name: 'BudgetBudgetManager',
                component: BudgetBudgetManager
            },
            {
                path: '/budgets/budgets/:id',
                name: 'BudgetBudgetDetail',
                component: BudgetBudgetDetail
            },

            {
                path: '/participationRates/researchers',
                name: 'ParticipationRateResearcherManager',
                component: ParticipationRateResearcherManager
            },
            {
                path: '/participationRates/researchers/:id',
                name: 'ParticipationRateResearcherDetail',
                component: ParticipationRateResearcherDetail
            },



    ]
})
