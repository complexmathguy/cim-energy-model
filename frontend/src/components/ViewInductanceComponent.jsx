import React, { Component } from 'react'
import InductanceService from '../services/InductanceService'

class ViewInductanceComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            inductance: {}
        }
    }

    componentDidMount(){
        InductanceService.getInductanceById(this.state.id).then( res => {
            this.setState({inductance: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Inductance Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> multiplier:&emsp; </label>
                            <div> { this.state.inductance.multiplier }</div>
                        </div>
                        <div className = "row">
                            <label> unit:&emsp; </label>
                            <div> { this.state.inductance.unit }</div>
                        </div>
                        <div className = "row">
                            <label> value:&emsp; </label>
                            <div> { this.state.inductance.value }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewInductanceComponent
