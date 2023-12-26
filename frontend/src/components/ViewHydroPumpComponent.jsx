import React, { Component } from 'react'
import HydroPumpService from '../services/HydroPumpService'

class ViewHydroPumpComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            hydroPump: {}
        }
    }

    componentDidMount(){
        HydroPumpService.getHydroPumpById(this.state.id).then( res => {
            this.setState({hydroPump: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View HydroPump Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewHydroPumpComponent
