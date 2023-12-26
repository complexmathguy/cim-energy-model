import React, { Component } from 'react'
import DiscExcContIEEEDEC2AService from '../services/DiscExcContIEEEDEC2AService'

class ViewDiscExcContIEEEDEC2AComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            discExcContIEEEDEC2A: {}
        }
    }

    componentDidMount(){
        DiscExcContIEEEDEC2AService.getDiscExcContIEEEDEC2AById(this.state.id).then( res => {
            this.setState({discExcContIEEEDEC2A: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View DiscExcContIEEEDEC2A Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> td1:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC2A.td1 }</div>
                        </div>
                        <div className = "row">
                            <label> td2:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC2A.td2 }</div>
                        </div>
                        <div className = "row">
                            <label> vdmax:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC2A.vdmax }</div>
                        </div>
                        <div className = "row">
                            <label> vdmin:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC2A.vdmin }</div>
                        </div>
                        <div className = "row">
                            <label> vk:&emsp; </label>
                            <div> { this.state.discExcContIEEEDEC2A.vk }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewDiscExcContIEEEDEC2AComponent
