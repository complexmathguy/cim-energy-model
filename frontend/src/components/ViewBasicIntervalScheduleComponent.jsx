import React, { Component } from 'react'
import BasicIntervalScheduleService from '../services/BasicIntervalScheduleService'

class ViewBasicIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            basicIntervalSchedule: {}
        }
    }

    componentDidMount(){
        BasicIntervalScheduleService.getBasicIntervalScheduleById(this.state.id).then( res => {
            this.setState({basicIntervalSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View BasicIntervalSchedule Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> startTime:&emsp; </label>
                            <div> { this.state.basicIntervalSchedule.startTime }</div>
                        </div>
                        <div className = "row">
                            <label> value1Unit:&emsp; </label>
                            <div> { this.state.basicIntervalSchedule.value1Unit }</div>
                        </div>
                        <div className = "row">
                            <label> value2Unit:&emsp; </label>
                            <div> { this.state.basicIntervalSchedule.value2Unit }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewBasicIntervalScheduleComponent
