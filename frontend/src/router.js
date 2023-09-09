
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import RegistrationProjectMasterManager from "./components/listers/RegistrationProjectMasterCards"
import RegistrationProjectMasterDetail from "./components/listers/RegistrationProjectMasterDetail"

import 집행ExpenseResolutionManager from "./components/listers/집행ExpenseResolutionCards"
import 집행ExpenseResolutionDetail from "./components/listers/집행ExpenseResolutionDetail"

import 정산ProjectManager from "./components/listers/정산ProjectCards"
import 정산ProjectDetail from "./components/listers/정산ProjectDetail"
import 정산ExpenseTableManager from "./components/listers/정산ExpenseTableTable"
import 정산ExpenseTableDetail from "./components/listers/정산ExpenseTableDetail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import BudgetBudgetManager from "./components/listers/BudgetBudgetCards"
import BudgetBudgetDetail from "./components/listers/BudgetBudgetDetail"

import Manager from "./components/listers/Cards"
import Detail from "./components/listers/Detail"
import ParticipationRateResearcherManager from "./components/listers/ParticipationRateResearcherCards"
import ParticipationRateResearcherDetail from "./components/listers/ParticipationRateResearcherDetail"

import 연구노트ResearchNoteManager from "./components/listers/연구노트ResearchNoteCards"
import 연구노트ResearchNoteDetail from "./components/listers/연구노트ResearchNoteDetail"


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
                path: '/집행/expenseResolutions',
                name: '집행ExpenseResolutionManager',
                component: 집행ExpenseResolutionManager
            },
            {
                path: '/집행/expenseResolutions/:id',
                name: '집행ExpenseResolutionDetail',
                component: 집행ExpenseResolutionDetail
            },

            {
                path: '/정산/projects',
                name: '정산ProjectManager',
                component: 정산ProjectManager
            },
            {
                path: '/정산/projects/:id',
                name: '정산ProjectDetail',
                component: 정산ProjectDetail
            },
            {
                path: '/정산/expenseTables',
                name: '정산ExpenseTableManager',
                component: 정산ExpenseTableManager
            },
            {
                path: '/정산/expenseTables/:id',
                name: '정산ExpenseTableDetail',
                component: 정산ExpenseTableDetail
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

            {
                path: '/연구노트/researchNotes',
                name: '연구노트ResearchNoteManager',
                component: 연구노트ResearchNoteManager
            },
            {
                path: '/연구노트/researchNotes/:id',
                name: '연구노트ResearchNoteDetail',
                component: 연구노트ResearchNoteDetail
            },



    ]
})
