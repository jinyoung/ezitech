
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import RegistrationProjectMasterManager from "./components/listers/RegistrationProjectMasterCards"
import RegistrationProjectMasterDetail from "./components/listers/RegistrationProjectMasterDetail"




import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import BudgetBudgetManager from "./components/listers/BudgetBudgetCards"
import BudgetBudgetDetail from "./components/listers/BudgetBudgetDetail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import ParticipationRateResearcherManager from "./components/listers/ParticipationRateResearcherCards"
import ParticipationRateResearcherDetail from "./components/listers/ParticipationRateResearcherDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
            },
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
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
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
                path: '//',
                name: 'Manager',
                component: Manager
            },
            {
                path: '///:id',
                name: 'Detail',
                component: Detail
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
