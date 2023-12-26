import React, { Component } from 'react'
import StringProxyService from '../services/StringProxyService';

class UpdateStringProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateStringProxy = this.updateStringProxy.bind(this);

    }

    componentDidMount(){
        StringProxyService.getStringProxyById(this.state.id).then( (res) =>{
            let stringProxy = res.data;
            this.setState({
            });
        });
    }

    updateStringProxy = (e) => {
        e.preventDefault();
        let stringProxy = {
            stringProxyId: this.state.id,
        };
        console.log('stringProxy => ' + JSON.stringify(stringProxy));
        console.log('id => ' + JSON.stringify(this.state.id));
        StringProxyService.updateStringProxy(stringProxy).then( res => {
            this.props.history.push('/stringProxys');
        });
    }


    cancel(){
        this.props.history.push('/stringProxys');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update StringProxy</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateStringProxy}>Save</button>
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

export default UpdateStringProxyComponent
