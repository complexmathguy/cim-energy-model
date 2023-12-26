import React, { Component } from 'react'
import RegulatingCondEqService from '../services/RegulatingCondEqService';

class CreateRegulatingCondEqComponent extends Component {
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
            RegulatingCondEqService.getRegulatingCondEqById(this.state.id).then( (res) =>{
                let regulatingCondEq = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateRegulatingCondEq = (e) => {
        e.preventDefault();
        let regulatingCondEq = {
                regulatingCondEqId: this.state.id,
            };
        console.log('regulatingCondEq => ' + JSON.stringify(regulatingCondEq));

        // step 5
        if(this.state.id === '_add'){
            regulatingCondEq.regulatingCondEqId=''
            RegulatingCondEqService.createRegulatingCondEq(regulatingCondEq).then(res =>{
                this.props.history.push('/regulatingCondEqs');
            });
        }else{
            RegulatingCondEqService.updateRegulatingCondEq(regulatingCondEq).then( res => {
                this.props.history.push('/regulatingCondEqs');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/regulatingCondEqs');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add RegulatingCondEq</h3>
        }else{
            return <h3 className="text-center">Update RegulatingCondEq</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateRegulatingCondEq}>Save</button>
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

export default CreateRegulatingCondEqComponent
