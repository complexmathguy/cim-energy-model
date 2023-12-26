import React, { Component } from 'react'
import NonConformLoadScheduleService from '../services/NonConformLoadScheduleService'

class ViewNonConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            nonConformLoadSchedule: {}
        }
    }

    componentDidMount(){
        NonConformLoadScheduleService.getNonConformLoadScheduleById(this.state.id).then( res => {
            this.setState({nonConformLoadSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View NonConformLoadSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewNonConformLoadScheduleComponent
