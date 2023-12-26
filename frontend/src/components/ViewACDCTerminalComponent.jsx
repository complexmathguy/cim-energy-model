import React, { Component } from 'react'
import ACDCTerminalService from '../services/ACDCTerminalService'

class ViewACDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            aCDCTerminal: {}
        }
    }

    componentDidMount(){
        ACDCTerminalService.getACDCTerminalById(this.state.id).then( res => {
            this.setState({aCDCTerminal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ACDCTerminal Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> sequenceNumber:&emsp; </label>
                            <div> { this.state.aCDCTerminal.sequenceNumber }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewACDCTerminalComponent
