import React, { Component } from 'react'
import SusceptanceService from '../services/SusceptanceService'

class ViewSusceptanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            susceptance: {}
        }
    }

    componentDidMount(){
        SusceptanceService.getSusceptanceById(this.state.id).then( res => {
            this.setState({susceptance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Susceptance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.susceptance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.susceptance.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.susceptance.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSusceptanceComponent
