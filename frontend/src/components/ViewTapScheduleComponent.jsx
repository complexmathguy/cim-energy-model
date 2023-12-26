import React, { Component } from 'react'
import TapScheduleService from '../services/TapScheduleService'

class ViewTapScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tapSchedule: {}
        }
    }

    componentDidMount(){
        TapScheduleService.getTapScheduleById(this.state.id).then( res => {
            this.setState({tapSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TapSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTapScheduleComponent
