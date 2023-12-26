import React, { Component } from 'react'
import GenICompensationForGenJService from '../services/GenICompensationForGenJService'

class ViewGenICompensationForGenJComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            genICompensationForGenJ: {}
        }
    }

    componentDidMount(){
        GenICompensationForGenJService.getGenICompensationForGenJById(this.state.id).then( res => {
            this.setState({genICompensationForGenJ: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GenICompensationForGenJ Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> rcij:&emsp; </label>
                            <div> { this.state.genICompensationForGenJ.rcij }</div>
                        </div>
                        <div className = "row">
                            <label> xcij:&emsp; </label>
                            <div> { this.state.genICompensationForGenJ.xcij }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGenICompensationForGenJComponent
