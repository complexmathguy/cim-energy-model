import React, { Component } from 'react'
import VCompIEEEType2Service from '../services/VCompIEEEType2Service';

class CreateVCompIEEEType2Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                tr: ''
        }
        this.changetrHandler = this.changetrHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            VCompIEEEType2Service.getVCompIEEEType2ById(this.state.id).then( (res) =>{
                let vCompIEEEType2 = res.data;
                this.setState({
                    tr: vCompIEEEType2.tr
                });
            });
        }        
    }
    saveOrUpdateVCompIEEEType2 = (e) => {
        e.preventDefault();
        let vCompIEEEType2 = {
                vCompIEEEType2Id: this.state.id,
                tr: this.state.tr
            };
        console.log('vCompIEEEType2 => ' + JSON.stringify(vCompIEEEType2));

        // step 5
        if(this.state.id === '_add'){
            vCompIEEEType2.vCompIEEEType2Id=''
            VCompIEEEType2Service.createVCompIEEEType2(vCompIEEEType2).then(res =>{
                this.props.history.push('/vCompIEEEType2s');
            });
        }else{
            VCompIEEEType2Service.updateVCompIEEEType2(vCompIEEEType2).then( res => {
                this.props.history.push('/vCompIEEEType2s');
            });
        }
    }
    
    changetrHandler= (event) => {
        this.setState({tr: event.target.value});
    }

    cancel(){
        this.props.history.push('/vCompIEEEType2s');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add VCompIEEEType2</h3>
        }else{
            return <h3 className="text-center">Update VCompIEEEType2</h3>
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
                                            <label> tr: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateVCompIEEEType2}>Save</button>
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

export default CreateVCompIEEEType2Component
