import React, { Component } from 'react'
import RegulationScheduleService from '../services/RegulationScheduleService'

class ViewRegulationScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            regulationSchedule: {}
        }
    }

    componentDidMount(){
        RegulationScheduleService.getRegulationScheduleById(this.state.id).then( res => {
            this.setState({regulationSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RegulationSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRegulationScheduleComponent
