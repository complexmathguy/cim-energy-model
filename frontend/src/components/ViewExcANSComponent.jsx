import React, { Component } from 'react'
import ExcANSService from '../services/ExcANSService'

class ViewExcANSComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excANS: {}
        }
    }

    componentDidMount(){
        ExcANSService.getExcANSById(this.state.id).then( res => {
            this.setState({excANS: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcANS Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> blint:&emsp; </label>
                            <div> { this.state.excANS.blint }</div>
                        </div>
                        <div className = "row">
                            <label> ifmn:&emsp; </label>
                            <div> { this.state.excANS.ifmn }</div>
                        </div>
                        <div className = "row">
                            <label> ifmx:&emsp; </label>
                            <div> { this.state.excANS.ifmx }</div>
                        </div>
                        <div className = "row">
                            <label> k2:&emsp; </label>
                            <div> { this.state.excANS.k2 }</div>
                        </div>
                        <div className = "row">
                            <label> k3:&emsp; </label>
                            <div> { this.state.excANS.k3 }</div>
                        </div>
                        <div className = "row">
                            <label> kce:&emsp; </label>
                            <div> { this.state.excANS.kce }</div>
                        </div>
                        <div className = "row">
                            <label> krvecc:&emsp; </label>
                            <div> { this.state.excANS.krvecc }</div>
                        </div>
                        <div className = "row">
                            <label> kvfif:&emsp; </label>
                            <div> { this.state.excANS.kvfif }</div>
                        </div>
                        <div className = "row">
                            <label> t1:&emsp; </label>
                            <div> { this.state.excANS.t1 }</div>
                        </div>
                        <div className = "row">
                            <label> t2:&emsp; </label>
                            <div> { this.state.excANS.t2 }</div>
                        </div>
                        <div className = "row">
                            <label> t3:&emsp; </label>
                            <div> { this.state.excANS.t3 }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excANS.tb }</div>
                        </div>
                        <div className = "row">
                            <label> vrmn:&emsp; </label>
                            <div> { this.state.excANS.vrmn }</div>
                        </div>
                        <div className = "row">
                            <label> vrmx:&emsp; </label>
                            <div> { this.state.excANS.vrmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcANSComponent
