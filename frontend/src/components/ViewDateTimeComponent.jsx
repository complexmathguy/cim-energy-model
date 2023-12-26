import React, { Component } from 'react'
import DateTimeService from '../services/DateTimeService'

class ViewDateTimeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dateTime: {}
        }
    }

    componentDidMount(){
        DateTimeService.getDateTimeById(this.state.id).then( res => {
            this.setState({dateTime: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DateTime Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDateTimeComponent
