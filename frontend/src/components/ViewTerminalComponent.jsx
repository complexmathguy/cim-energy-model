import React, { Component } from 'react'
import TerminalService from '../services/TerminalService'

class ViewTerminalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            terminal: {}
        }
    }

    componentDidMount(){
        TerminalService.getTerminalById(this.state.id).then( res => {
            this.setState({terminal: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Terminal Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTerminalComponent
