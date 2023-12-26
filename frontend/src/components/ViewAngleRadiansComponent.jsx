import React, { Component } from 'react'
import AngleRadiansService from '../services/AngleRadiansService'

class ViewAngleRadiansComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            angleRadians: {}
        }
    }

    componentDidMount(){
        AngleRadiansService.getAngleRadiansById(this.state.id).then( res => {
            this.setState({angleRadians: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AngleRadians Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.angleRadians.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.angleRadians.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.angleRadians.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAngleRadiansComponent
