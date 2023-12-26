import React, { Component } from 'react'
import TieFlowService from '../services/TieFlowService'

class ViewTieFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tieFlow: {}
        }
    }

    componentDidMount(){
        TieFlowService.getTieFlowById(this.state.id).then( res => {
            this.setState({tieFlow: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TieFlow Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> positiveFlowIn:&emsp; </label>
                            <div> { this.state.tieFlow.positiveFlowIn }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTieFlowComponent
