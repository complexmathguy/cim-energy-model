import React, { Component } from 'react'
import Pss1Service from '../services/Pss1Service'

class ViewPss1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss1: {}
        }
    }

    componentDidMount(){
        Pss1Service.getPss1ById(this.state.id).then( res => {
            this.setState({pss1: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss1 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.pss1.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kpe:&emsp; </label>
                            <div> { this.state.pss1.kpe }</div>
                        </div>
                        <div className = "row">
                            <label> ks:&emsp; </label>
                            <div> { this.state.pss1.ks }</div>
                        </div>
                        <div className = "row">
                            <label> kw:&emsp; </label>
                            <div> { this.state.pss1.kw }</div>
                        </div>
                        <div className = "row">
                            <label> pmin:&emsp; </label>
                            <div> { this.state.pss1.pmin }</div>
                        </div>
                        <div className = "row">
                            <label> t10:&emsp; </label>
                            <div> { this.state.pss1.t10 }</div>
                        </div>
                        <div className = "row">
                            <label> t5:&emsp; </label>
                            <div> { this.state.pss1.t5 }</div>
                        </div>
                        <div className = "row">
                            <label> t6:&emsp; </label>
                            <div> { this.state.pss1.t6 }</div>
                        </div>
                        <div className = "row">
                            <label> t7:&emsp; </label>
                            <div> { this.state.pss1.t7 }</div>
                        </div>
                        <div className = "row">
                            <label> t8:&emsp; </label>
                            <div> { this.state.pss1.t8 }</div>
                        </div>
                        <div className = "row">
                            <label> t9:&emsp; </label>
                            <div> { this.state.pss1.t9 }</div>
                        </div>
                        <div className = "row">
                            <label> tpe:&emsp; </label>
                            <div> { this.state.pss1.tpe }</div>
                        </div>
                        <div className = "row">
                            <label> vadat:&emsp; </label>
                            <div> { this.state.pss1.vadat }</div>
                        </div>
                        <div className = "row">
                            <label> vsmn:&emsp; </label>
                            <div> { this.state.pss1.vsmn }</div>
                        </div>
                        <div className = "row">
                            <label> vsmx:&emsp; </label>
                            <div> { this.state.pss1.vsmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss1Component
