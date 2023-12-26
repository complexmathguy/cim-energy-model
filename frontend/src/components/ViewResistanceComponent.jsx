import React, { Component } from 'react'
import ResistanceService from '../services/ResistanceService'

class ViewResistanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            resistance: {}
        }
    }

    componentDidMount(){
        ResistanceService.getResistanceById(this.state.id).then( res => {
            this.setState({resistance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Resistance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.resistance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.resistance.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.resistance.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewResistanceComponent
