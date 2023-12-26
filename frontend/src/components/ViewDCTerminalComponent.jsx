import React, { Component } from 'react'
import DCTerminalService from '../services/DCTerminalService'

class ViewDCTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCTerminal: {}
        }
    }

    componentDidMount(){
        DCTerminalService.getDCTerminalById(this.state.id).then( res => {
            this.setState({dCTerminal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCTerminal Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCTerminalComponent
