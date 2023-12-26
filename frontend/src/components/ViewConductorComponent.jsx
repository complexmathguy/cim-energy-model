import React, { Component } from 'react'
import ConductorService from '../services/ConductorService'

class ViewConductorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            conductor: {}
        }
    }

    componentDidMount(){
        ConductorService.getConductorById(this.state.id).then( res => {
            this.setState({conductor: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Conductor Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> length:&emsp; </label>
                            <div> { this.state.conductor.length }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewConductorComponent
