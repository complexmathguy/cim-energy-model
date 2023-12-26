import React, { Component } from 'react'
import LoadStaticService from '../services/LoadStaticService'

class ViewLoadStaticComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            loadStatic: {}
        }
    }

    componentDidMount(){
        LoadStaticService.getLoadStaticById(this.state.id).then( res => {
            this.setState({loadStatic: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View LoadStatic Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ep1:&emsp; </label>
                            <div> { this.state.loadStatic.ep1 }</div>
                        </div>
                        <div className = "row">
                            <label> ep2:&emsp; </label>
                            <div> { this.state.loadStatic.ep2 }</div>
                        </div>
                        <div className = "row">
                            <label> ep3:&emsp; </label>
                            <div> { this.state.loadStatic.ep3 }</div>
                        </div>
                        <div className = "row">
                            <label> eq1:&emsp; </label>
                            <div> { this.state.loadStatic.eq1 }</div>
                        </div>
                        <div className = "row">
                            <label> eq2:&emsp; </label>
                            <div> { this.state.loadStatic.eq2 }</div>
                        </div>
                        <div className = "row">
                            <label> eq3:&emsp; </label>
                            <div> { this.state.loadStatic.eq3 }</div>
                        </div>
                        <div className = "row">
                            <label> kp1:&emsp; </label>
                            <div> { this.state.loadStatic.kp1 }</div>
                        </div>
                        <div className = "row">
                            <label> kp2:&emsp; </label>
                            <div> { this.state.loadStatic.kp2 }</div>
                        </div>
                        <div className = "row">
                            <label> kp3:&emsp; </label>
                            <div> { this.state.loadStatic.kp3 }</div>
                        </div>
                        <div className = "row">
                            <label> kp4:&emsp; </label>
                            <div> { this.state.loadStatic.kp4 }</div>
                        </div>
                        <div className = "row">
                            <label> kpf:&emsp; </label>
                            <div> { this.state.loadStatic.kpf }</div>
                        </div>
                        <div className = "row">
                            <label> kq1:&emsp; </label>
                            <div> { this.state.loadStatic.kq1 }</div>
                        </div>
                        <div className = "row">
                            <label> kq2:&emsp; </label>
                            <div> { this.state.loadStatic.kq2 }</div>
                        </div>
                        <div className = "row">
                            <label> kq3:&emsp; </label>
                            <div> { this.state.loadStatic.kq3 }</div>
                        </div>
                        <div className = "row">
                            <label> kq4:&emsp; </label>
                            <div> { this.state.loadStatic.kq4 }</div>
                        </div>
                        <div className = "row">
                            <label> kqf:&emsp; </label>
                            <div> { this.state.loadStatic.kqf }</div>
                        </div>
                        <div className = "row">
                            <label> staticLoadModelType:&emsp; </label>
                            <div> { this.state.loadStatic.staticLoadModelType }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewLoadStaticComponent
