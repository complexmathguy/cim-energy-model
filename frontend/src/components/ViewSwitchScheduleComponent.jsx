import React, { Component } from 'react'
import SwitchScheduleService from '../services/SwitchScheduleService'

class ViewSwitchScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            switchSchedule: {}
        }
    }

    componentDidMount(){
        SwitchScheduleService.getSwitchScheduleById(this.state.id).then( res => {
            this.setState({switchSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SwitchSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSwitchScheduleComponent
