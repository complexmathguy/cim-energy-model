import React, { Component } from 'react'
import IntegerProxyService from '../services/IntegerProxyService';

class CreateIntegerProxyComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            IntegerProxyService.getIntegerProxyById(this.state.id).then( (res) =>{
                let integerProxy = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateIntegerProxy = (e) => {
        e.preventDefault();
        let integerProxy = {
                integerProxyId: this.state.id,
            };
        console.log('integerProxy => ' + JSON.stringify(integerProxy));

        // step 5
        if(this.state.id === '_add'){
            integerProxy.integerProxyId=''
            IntegerProxyService.createIntegerProxy(integerProxy).then(res =>{
                this.props.history.push('/integerProxys');
            });
        }else{
            IntegerProxyService.updateIntegerProxy(integerProxy).then( res => {
                this.props.history.push('/integerProxys');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/integerProxys');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add IntegerProxy</h3>
        }else{
            return <h3 className="text-center">Update IntegerProxy</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateIntegerProxy}>Save</button>
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

export default CreateIntegerProxyComponent
