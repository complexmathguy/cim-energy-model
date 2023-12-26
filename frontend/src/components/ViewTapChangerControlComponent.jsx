import React, { Component } from 'react'
import TapChangerControlService from '../services/TapChangerControlService'

class ViewTapChangerControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            tapChangerControl: {}
        }
    }

    componentDidMount(){
        TapChangerControlService.getTapChangerControlById(this.state.id).then( res => {
            this.setState({tapChangerControl: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View TapChangerControl Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewTapChangerControlComponent
