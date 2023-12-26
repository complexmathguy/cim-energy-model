import React, { Component } from 'react'
import ControlAreaGeneratingUnitService from '../services/ControlAreaGeneratingUnitService'

class ViewControlAreaGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            controlAreaGeneratingUnit: {}
        }
    }

    componentDidMount(){
        ControlAreaGeneratingUnitService.getControlAreaGeneratingUnitById(this.state.id).then( res => {
            this.setState({controlAreaGeneratingUnit: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ControlAreaGeneratingUnit Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewControlAreaGeneratingUnitComponent
