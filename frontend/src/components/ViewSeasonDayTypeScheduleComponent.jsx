import React, { Component } from 'react'
import SeasonDayTypeScheduleService from '../services/SeasonDayTypeScheduleService'

class ViewSeasonDayTypeScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            seasonDayTypeSchedule: {}
        }
    }

    componentDidMount(){
        SeasonDayTypeScheduleService.getSeasonDayTypeScheduleById(this.state.id).then( res => {
            this.setState({seasonDayTypeSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View SeasonDayTypeSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSeasonDayTypeScheduleComponent
