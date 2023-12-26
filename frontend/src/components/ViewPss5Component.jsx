import React, { Component } from 'react'
import Pss5Service from '../services/Pss5Service'

class ViewPss5Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            pss5: {}
        }
    }

    componentDidMount(){
        Pss5Service.getPss5ById(this.state.id).then( res => {
            this.setState({pss5: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Pss5 Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> ctw2:&emsp; </label>
                            <div> { this.state.pss5.ctw2 }</div>
                        </div>
                        <div className = "row">
                            <label> deadband:&emsp; </label>
                            <div> { this.state.pss5.deadband }</div>
                        </div>
                        <div className = "row">
                            <label> isfreq:&emsp; </label>
                            <div> { this.state.pss5.isfreq }</div>
                        </div>
                        <div className = "row">
                            <label> kf:&emsp; </label>
                            <div> { this.state.pss5.kf }</div>
                        </div>
                        <div className = "row">
                            <label> kpe:&emsp; </label>
                            <div> { this.state.pss5.kpe }</div>
                        </div>
                        <div className = "row">
                            <label> kpss:&emsp; </label>
                            <div> { this.state.pss5.kpss }</div>
                        </div>
                        <div className = "row">
                            <label> pmm:&emsp; </label>
                            <div> { this.state.pss5.pmm }</div>
                        </div>
                        <div className = "row">
                            <label> tl1:&emsp; </label>
                            <div> { this.state.pss5.tl1 }</div>
                        </div>
                        <div className = "row">
                            <label> tl2:&emsp; </label>
                            <div> { this.state.pss5.tl2 }</div>
                        </div>
                        <div className = "row">
                            <label> tl3:&emsp; </label>
                            <div> { this.state.pss5.tl3 }</div>
                        </div>
                        <div className = "row">
                            <label> tl4:&emsp; </label>
                            <div> { this.state.pss5.tl4 }</div>
                        </div>
                        <div className = "row">
                            <label> tpe:&emsp; </label>
                            <div> { this.state.pss5.tpe }</div>
                        </div>
                        <div className = "row">
                            <label> tw1:&emsp; </label>
                            <div> { this.state.pss5.tw1 }</div>
                        </div>
                        <div className = "row">
                            <label> tw2:&emsp; </label>
                            <div> { this.state.pss5.tw2 }</div>
                        </div>
                        <div className = "row">
                            <label> vadat:&emsp; </label>
                            <div> { this.state.pss5.vadat }</div>
                        </div>
                        <div className = "row">
                            <label> vsmn:&emsp; </label>
                            <div> { this.state.pss5.vsmn }</div>
                        </div>
                        <div className = "row">
                            <label> vsmx:&emsp; </label>
                            <div> { this.state.pss5.vsmx }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewPss5Component
