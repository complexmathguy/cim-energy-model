import React, { Component } from 'react'
import MonthDayIntervalService from '../services/MonthDayIntervalService'

class ViewMonthDayIntervalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            monthDayInterval: {}
        }
    }

    componentDidMount(){
        MonthDayIntervalService.getMonthDayIntervalById(this.state.id).then( res => {
            this.setState({monthDayInterval: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MonthDayInterval Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> end:&emsp; </label>
                            <div> { this.state.monthDayInterval.end }</div>
                        </div>
                        <div className = "row">
                            <label> start:&emsp; </label>
                            <div> { this.state.monthDayInterval.start }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMonthDayIntervalComponent
