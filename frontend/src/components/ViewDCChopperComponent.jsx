import React, { Component } from 'react'
import DCChopperService from '../services/DCChopperService'

class ViewDCChopperComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCChopper: {}
        }
    }

    componentDidMount(){
        DCChopperService.getDCChopperById(this.state.id).then( res => {
            this.setState({dCChopper: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCChopper Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCChopperComponent
