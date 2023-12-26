import React, { Component } from 'react'
import DCBaseTerminalService from '../services/DCBaseTerminalService'

class ViewDCBaseTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCBaseTerminal: {}
        }
    }

    componentDidMount(){
        DCBaseTerminalService.getDCBaseTerminalById(this.state.id).then( res => {
            this.setState({dCBaseTerminal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCBaseTerminal Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCBaseTerminalComponent
