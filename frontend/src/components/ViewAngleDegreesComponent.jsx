import React, { Component } from 'react'
import AngleDegreesService from '../services/AngleDegreesService'

class ViewAngleDegreesComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            angleDegrees: {}
        }
    }

    componentDidMount(){
        AngleDegreesService.getAngleDegreesById(this.state.id).then( res => {
            this.setState({angleDegrees: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View AngleDegrees Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.angleDegrees.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.angleDegrees.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.angleDegrees.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewAngleDegreesComponent
