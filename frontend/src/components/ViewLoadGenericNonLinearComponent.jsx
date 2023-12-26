import React, { Component } from 'react'
import LoadGenericNonLinearService from '../services/LoadGenericNonLinearService'

class ViewLoadGenericNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadGenericNonLinear: {}
        }
    }

    componentDidMount(){
        LoadGenericNonLinearService.getLoadGenericNonLinearById(this.state.id).then( res => {
            this.setState({loadGenericNonLinear: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadGenericNonLinear Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> bs:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.bs }</div>
                        </div>
                        <div className = "row">
                            <label> bt:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.bt }</div>
                        </div>
                        <div className = "row">
                            <label> genericNonLinearLoadModelType:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.genericNonLinearLoadModelType }</div>
                        </div>
                        <div className = "row">
                            <label> ls:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.ls }</div>
                        </div>
                        <div className = "row">
                            <label> lt:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.lt }</div>
                        </div>
                        <div className = "row">
                            <label> pt:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.pt }</div>
                        </div>
                        <div className = "row">
                            <label> qt:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.qt }</div>
                        </div>
                        <div className = "row">
                            <label> tp:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.tp }</div>
                        </div>
                        <div className = "row">
                            <label> tq:&emsp; </label>
                            <div> { this.state.loadGenericNonLinear.tq }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadGenericNonLinearComponent
