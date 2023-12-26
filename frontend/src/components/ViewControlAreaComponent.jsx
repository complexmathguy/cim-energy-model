import React, { Component } from 'react'
import ControlAreaService from '../services/ControlAreaService'

class ViewControlAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            controlArea: {}
        }
    }

    componentDidMount(){
        ControlAreaService.getControlAreaById(this.state.id).then( res => {
            this.setState({controlArea: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ControlArea Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> type:&emsp; </label>
                            <div> { this.state.controlArea.type }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewControlAreaComponent
