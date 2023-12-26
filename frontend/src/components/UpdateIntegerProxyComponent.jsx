import React, { Component } from 'react'
import IntegerProxyService from '../services/IntegerProxyService';

class UpdateIntegerProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateIntegerProxy = this.updateIntegerProxy.bind(this);

    }

    componentDidMount(){
        IntegerProxyService.getIntegerProxyById(this.state.id).then( (res) =>{
            let integerProxy = res.data;
            this.setState({
            });
        });
    }

    updateIntegerProxy = (e) => {
        e.preventDefault();
        let integerProxy = {
            integerProxyId: this.state.id,
        };
        console.log('integerProxy => ' + JSON.stringify(integerProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        IntegerProxyService.updateIntegerProxy(integerProxy).then( res => {
            this.props.history.push('/integerProxys');
        });
    }


    cancel(){
        this.props.history.push('/integerProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update IntegerProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateIntegerProxy}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateIntegerProxyComponent
