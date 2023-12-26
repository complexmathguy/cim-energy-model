import React, { Component } from 'react'
import ResistancePerLengthService from '../services/ResistancePerLengthService'

class ViewResistancePerLengthComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            resistancePerLength: {}
        }
    }

    componentDidMount(){
        ResistancePerLengthService.getResistancePerLengthById(this.state.id).then( res => {
            this.setState({resistancePerLength: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ResistancePerLength Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> denominatorMultiplier:&emsp; </label>
                            <div> { this.state.resistancePerLength.denominatorMultiplier }</div>
                        </div>
                        <div className = "row">
                            <label> denominatorUnit:&emsp; </label>
                            <div> { this.state.resistancePerLength.denominatorUnit }</div>
                        </div>
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.resistancePerLength.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.resistancePerLength.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.resistancePerLength.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewResistancePerLengthComponent
