import React, { Component } from 'react'
import DCBusbarService from '../services/DCBusbarService'

class ViewDCBusbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            dCBusbar: {}
        }
    }

    componentDidMount(){
        DCBusbarService.getDCBusbarById(this.state.id).then( res => {
            this.setState({dCBusbar: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DCBusbar Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDCBusbarComponent
