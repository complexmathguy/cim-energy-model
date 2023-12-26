import React, { Component } from 'react'
import DayTypeService from '../services/DayTypeService'

class ViewDayTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dayType: {}
        }
    }

    componentDidMount(){
        DayTypeService.getDayTypeById(this.state.id).then( res => {
            this.setState({dayType: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DayType Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDayTypeComponent
