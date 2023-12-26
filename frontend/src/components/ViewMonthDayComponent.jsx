import React, { Component } from 'react'
import MonthDayService from '../services/MonthDayService'

class ViewMonthDayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            monthDay: {}
        }
    }

    componentDidMount(){
        MonthDayService.getMonthDayById(this.state.id).then( res => {
            this.setState({monthDay: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View MonthDay Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewMonthDayComponent
