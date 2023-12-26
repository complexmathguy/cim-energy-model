import React, { Component } from 'react'
import ExcST7BService from '../services/ExcST7BService'

class ViewExcST7BComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            excST7B: {}
        }
    }

    componentDidMount(){
        ExcST7BService.getExcST7BById(this.state.id).then( res => {
            this.setState({excST7B: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View ExcST7B Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> kh:&emsp; </label>
                            <div> { this.state.excST7B.kh }</div>
                        </div>
                        <div className = "row">
                            <label> kia:&emsp; </label>
                            <div> { this.state.excST7B.kia }</div>
                        </div>
                        <div className = "row">
                            <label> kl:&emsp; </label>
                            <div> { this.state.excST7B.kl }</div>
                        </div>
                        <div className = "row">
                            <label> kpa:&emsp; </label>
                            <div> { this.state.excST7B.kpa }</div>
                        </div>
                        <div className = "row">
                            <label> oelin:&emsp; </label>
                            <div> { this.state.excST7B.oelin }</div>
                        </div>
                        <div className = "row">
                            <label> tb:&emsp; </label>
                            <div> { this.state.excST7B.tb }</div>
                        </div>
                        <div className = "row">
                            <label> tc:&emsp; </label>
                            <div> { this.state.excST7B.tc }</div>
                        </div>
                        <div className = "row">
                            <label> tf:&emsp; </label>
                            <div> { this.state.excST7B.tf }</div>
                        </div>
                        <div className = "row">
                            <label> tg:&emsp; </label>
                            <div> { this.state.excST7B.tg }</div>
                        </div>
                        <div className = "row">
                            <label> tia:&emsp; </label>
                            <div> { this.state.excST7B.tia }</div>
                        </div>
                        <div className = "row">
                            <label> ts:&emsp; </label>
                            <div> { this.state.excST7B.ts }</div>
                        </div>
                        <div className = "row">
                            <label> uelin:&emsp; </label>
                            <div> { this.state.excST7B.uelin }</div>
                        </div>
                        <div className = "row">
                            <label> vmax:&emsp; </label>
                            <div> { this.state.excST7B.vmax }</div>
                        </div>
                        <div className = "row">
                            <label> vmin:&emsp; </label>
                            <div> { this.state.excST7B.vmin }</div>
                        </div>
                        <div className = "row">
                            <label> vrmax:&emsp; </label>
                            <div> { this.state.excST7B.vrmax }</div>
                        </div>
                        <div className = "row">
                            <label> vrmin:&emsp; </label>
                            <div> { this.state.excST7B.vrmin }</div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewExcST7BComponent
