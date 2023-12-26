import React, { Component } from 'react'
import ExcST4BService from '../services/ExcST4BService'

class ViewExcST4BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST4B: {}
        }
    }

    componentDidMount(){
        ExcST4BService.getExcST4BById(this.state.id).then( res => {
            this.setState({excST4B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST4B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kc:&emsp; </label>
                            <div> { this.state.excST4B.kc }</div>
                        </div>
                        <div className = "row">
                            <label> kg:&emsp; </label>
                            <div> { this.state.excST4B.kg }</div>
                        </div>
                        <div className = "row">
                            <label> ki:&emsp; </label>
                            <div> { this.state.excST4B.ki }</div>
                        </div>
                        <div className = "row">
                            <label> kim:&emsp; </label>
                            <div> { this.state.excST4B.kim }</div>
                        </div>
                        <div className = "row">
                            <label> kir:&emsp; </label>
                            <div> { this.state.excST4B.kir }</div>
                        </div>
                        <div className = "row">
                            <label> kp:&emsp; </label>
                            <div> { this.state.excST4B.kp }</div>
                        </div>
                        <div className = "row">
                            <label> kpm:&emsp; </label>
                            <div> { this.state.excST4B.kpm }</div>
                        </div>
                        <div className = "row">
                            <label> kpr:&emsp; </label>
                            <div> { this.state.excST4B.kpr }</div>
                        </div>
                        <div className = "row">
                            <label> lvgate:&emsp; </label>
                            <div> { this.state.excST4B.lvgate }</div>
                        </div>
                        <div className = "row">
                            <label> ta:&emsp; </label>
                            <div> { this.state.excST4B.ta }</div>
                        </div>
                        <div className = "row">
                            <label> thetap:&emsp; </label>
                            <div> { this.state.excST4B.thetap }</div>
                        </div>
                        <div className = "row">
                            <label> uel:&emsp; </label>
                            <div> { this.state.excST4B.uel }</div>
                        </div>
                        <div className = "row">
                            <label> vbmax:&emsp; </label>
                            <div> { this.state.excST4B.vbmax }</div>
                        </div>
                        <div className = "row">
                            <label> vgmax:&emsp; </label>
                            <div> { this.state.excST4B.vgmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmmax:&emsp; </label>
                            <div> { this.state.excST4B.vmmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmmin:&emsp; </label>
                            <div> { this.state.excST4B.vmmin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST4B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST4B.vrmin }</div>
                        </div>
                        <div className = "row">
                            <label> xl:&emsp; </label>
                            <div> { this.state.excST4B.xl }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST4BComponent
