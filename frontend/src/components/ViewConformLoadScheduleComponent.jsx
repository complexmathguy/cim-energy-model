import React, { Component } from 'react'
import ConformLoadScheduleService from '../services/ConformLoadScheduleService'

class ViewConformLoadScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conformLoadSchedule: {}
        }
    }

    componentDidMount(){
        ConformLoadScheduleService.getConformLoadScheduleById(this.state.id).then( res => {
            this.setState({conformLoadSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ConformLoadSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConformLoadScheduleComponent
