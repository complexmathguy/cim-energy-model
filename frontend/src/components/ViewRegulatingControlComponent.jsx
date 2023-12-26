import React, { Component } from 'react'
import RegulatingControlService from '../services/RegulatingControlService'

class ViewRegulatingControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            regulatingControl: {}
        }
    }

    componentDidMount(){
        RegulatingControlService.getRegulatingControlById(this.state.id).then( res => {
            this.setState({regulatingControl: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RegulatingControl Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> mode:&emsp; </label>
                            <div> { this.state.regulatingControl.mode }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRegulatingControlComponent
