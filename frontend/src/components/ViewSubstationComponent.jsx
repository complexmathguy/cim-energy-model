import React, { Component } from 'react'
import SubstationService from '../services/SubstationService'

class ViewSubstationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            substation: {}
        }
    }

    componentDidMount(){
        SubstationService.getSubstationById(this.state.id).then( res => {
            this.setState({substation: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Substation Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewSubstationComponent
