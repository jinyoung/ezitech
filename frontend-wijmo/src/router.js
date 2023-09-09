
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProjectMasterManager from "./components/ui/ProjectMasterGrid"

import ExpenseResolutionManager from "./components/ui/ExpenseResolutionGrid"

import ProjectManager from "./components/ui/ProjectGrid"
import ExpenseTableManager from "./components/ui/ExpenseTableGrid"

import BudgetManager from "./components/ui/BudgetGrid"

import ResearcherManager from "./components/ui/ResearcherGrid"

import ResearchNoteManager from "./components/ui/ResearchNoteGrid"


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
                path: '/expenseResolutions',
                name: 'ExpenseResolutionManager',
                component: ExpenseResolutionManager
            },

            {
                path: '/projects',
                name: 'ProjectManager',
                component: ProjectManager
            },
            {
                path: '/expenseTables',
                name: 'ExpenseTableManager',
                component: ExpenseTableManager
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

            {
                path: '/researchNotes',
                name: 'ResearchNoteManager',
                component: ResearchNoteManager
            },



    ]
})
